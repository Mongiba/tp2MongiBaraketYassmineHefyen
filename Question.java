package tp2reing;

import java.util.LinkedList;

public class Question extends Game {
	private static LinkedList<String> _popQuestions = new LinkedList<String>();
	private static LinkedList<String> _scienceQuestions = new LinkedList<String>();
	private static LinkedList<String> _sportsQuestions = new LinkedList<String>();
	private static LinkedList<String> _rockQuestions = new LinkedList<String>();

	public LinkedList<String> get_popQuestions() {
		return _popQuestions;
	}

	public void set_popQuestions(LinkedList<String> _popQuestions) {
		this._popQuestions = _popQuestions;
	}

	public LinkedList<String> get_scienceQuestions() {
		return _scienceQuestions;
	}

	public void set_scienceQuestions(LinkedList<String> _scienceQuestions) {
		this._scienceQuestions = _scienceQuestions;
	}

	public LinkedList<String> get_sportsQuestions() {
		return _sportsQuestions;
	}

	public void set_sportsQuestions(LinkedList<String> _sportsQuestions) {
		this._sportsQuestions = _sportsQuestions;
	}

	public LinkedList<String> get_rockQuestions() {
		return _rockQuestions;
	}

	public void set_rockQuestions(LinkedList<String> _rockQuestions) {
		this._rockQuestions = _rockQuestions;
	}

	public Question() {
		for (var i = 0; i < 50; i++) {
			_popQuestions.addLast(CreatePopQuestion(i));
			_scienceQuestions.addLast(CreateScienceQuestion(i));
			_sportsQuestions.addLast(CreateSportsQuestion(i));
			_rockQuestions.addLast(CreateRockQuestion(i));
		}
	}

	private String CreateRockQuestion(int index) {
		return "Rock Question " + index;
	}

	private String CreatePopQuestion(int index) {
		return "Pop Question " + index;
	}

	private String CreateScienceQuestion(int index) {
		return "Science Question " + index;
	}

	private String CreateSportsQuestion(int index) {
		return "Sports Question " + index;
	}
	public static void AskQuestion() {
		if (Player.CurrentCategory() == "Pop") {
			System.out.println(_popQuestions.getFirst());
			_popQuestions.removeFirst();
		}
		if (Player.CurrentCategory() == "Science") {
			System.out.println(_scienceQuestions.getFirst());
			_scienceQuestions.removeFirst();
		}
		if (Player.CurrentCategory() == "Sports") {
			System.out.println(_sportsQuestions.getFirst());
			_sportsQuestions.removeFirst();
		}
		if (Player.CurrentCategory() == "Rock") {
			System.out.println(_rockQuestions.getFirst());
			_rockQuestions.removeFirst();
		}
	}
	
}
