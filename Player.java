package tp2reing;

import java.util.ArrayList;

public class Player extends Game{
	private static ArrayList<String> _players = new ArrayList<String>();
	private static int[] _places = new int[6];
	private int[] _purses = new int[6];
	private static boolean[] _inPenaltyBox = new boolean[6];
	private static int _currentPlayer;
	private static boolean _isGettingOutOfPenaltyBox;
	public static ArrayList<String> get_players() {
		return _players;
	}
	public void set_players(ArrayList<String> _players) {
		this._players = _players;
	}
	public int[] get_places() {
		return _places;
	}
	public void set_places(int[] _places) {
		this._places = _places;
	}
	public int[] get_purses() {
		return _purses;
	}
	public void set_purses(int[] _purses) {
		this._purses = _purses;
	}
	public boolean[] get_inPenaltyBox() {
		return _inPenaltyBox;
	}
	public void set_inPenaltyBox(boolean[] _inPenaltyBox) {
		this._inPenaltyBox = _inPenaltyBox;
	}
	public static int get_currentPlayer() {
		return _currentPlayer;
	}
	public void set_currentPlayer(int _currentPlayer) {
		this._currentPlayer = _currentPlayer;
	}
	public boolean is_isGettingOutOfPenaltyBox() {
		return _isGettingOutOfPenaltyBox;
	}
	public void set_isGettingOutOfPenaltyBox(boolean _isGettingOutOfPenaltyBox) {
		this._isGettingOutOfPenaltyBox = _isGettingOutOfPenaltyBox;
	}
	private boolean IsPlayable() {
		return (HowManyPlayers() >= 2);
	}
	private boolean Add(String playerName) {
		_players.add(playerName);
		_places[HowManyPlayers()] = 0;
		_purses[HowManyPlayers()] = 0;
		_inPenaltyBox[HowManyPlayers()] = false;
		System.out.println(playerName + " was added");
		System.out.println("They are player number " + _players.size());
		return true;
	}
	private int HowManyPlayers() {
		return _players.size();
	}
	protected static void Placeplayer(int roll) {
		if (_inPenaltyBox[_currentPlayer]) {
			if (roll % 2 != 0) {
				_isGettingOutOfPenaltyBox = true;
				System.out.println(_players.get(_currentPlayer) + " is getting out of the penalty box");
				playeraction(roll);
			} else {
				System.out.println(_players.get(_currentPlayer) + " is not getting out of the penalty box");
				_isGettingOutOfPenaltyBox = false;
			}
		} else {
			playeraction(roll);
		
	}
}
	private static void playeraction(int roll) {
		_places[_currentPlayer] = _places[_currentPlayer] + roll;
		if (_places[_currentPlayer] > 11)
			_places[_currentPlayer] = _places[_currentPlayer] - 12;
		System.out.println(_players.get(_currentPlayer) + "'s new location is " + _places[_currentPlayer]);
		System.out.println("The category is " + CurrentCategory());
		Question.AskQuestion();
	}
	public static String CurrentCategory() {
		int p=_places[_currentPlayer];
		if (p == 0||p==4||p==8 )
			return "Pop";
		
		if (p == 1||p==5||p==9)
			return "Science";
		
		if (p == 2||p==6||p==10)
			return "Sports";
		
		return "Rock";
	}
	

	public boolean WasCorrectlyAnswered() {
		if (_inPenaltyBox[_currentPlayer]) {
			if (_isGettingOutOfPenaltyBox) {
				return correct();
			} else {
				curplayer();
				return true;
			}
		} else {
			return correct();
		}
	}
	private boolean correct() {
		System.out.println("Answer was correct!!!!");
		_purses[_currentPlayer]++;
		System.out.println(_players.get(_currentPlayer) + " now has " + _purses[_currentPlayer] + " Gold Coins.");
		var winner = DidPlayerWin();
		curplayer();
		return winner;
	}
	private void curplayer() {
		_currentPlayer++;
		if (_currentPlayer == _players.size())
			_currentPlayer = 0;
	}

	public boolean WrongAnswer() {
		System.out.println("Question was incorrectly answered");
		System.out.println(_players.get(_currentPlayer) + " was sent to the penalty box");
		_inPenaltyBox[_currentPlayer] = true;
		curplayer();
		return true;
	}

	private boolean DidPlayerWin() {
		return !(_purses[_currentPlayer] == 6);
	}
}
