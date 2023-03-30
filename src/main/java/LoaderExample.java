import java.io.IOException;

public class LoaderExample {

	public static void main(String[] args) {
		Loaders loader = new Loaders();
		try {
			System.out.println(loader.loadTopic("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/Topic.csv"));
			System.out.println(loader.loadEdition("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/Editions.csv"));
			System.out.println(loader.loadEmail("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/Emails.csv"));
			System.out.println(loader.loadFootage("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/Footage.csv"));
			System.out.println(loader.loadItem("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/Item.csv"));
			System.out.println(loader.loadJournalist("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/Journalists.csv"));
			System.out.println(loader.loadPhone("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/PhoneNumbers.csv"));
			System.out.println(loader.loadRoles("/Users/anthonhertzbie/IdeaProjects/DraftForDatabase/src/recources/Roles.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


