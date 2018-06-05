public class Main {
    public static void main(String[] args) {
        Indexer indexer = new Indexer();
        Searcher searcher = new Searcher();
        searcher.search("Ronaldo", indexer.getIndexReader());
    }
}
