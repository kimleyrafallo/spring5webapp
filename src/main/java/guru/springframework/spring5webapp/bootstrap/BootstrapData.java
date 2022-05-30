package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

        private final AuthorRepository authorRepository;
        private final BookRepository bookRepository;

        private final PublisherRepository publisherRepository;

        public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
            this.authorRepository = authorRepository;
            this.bookRepository = bookRepository;
            this.publisherRepository = publisherRepository;
        }

        @Override
        public void run(String... args) throws Exception {
            Author author = new Author("Eric", "Evans");
            Book book = new Book("The Choke", "123212340967");

            author.getBooks().add(book);
            book.getAuthors().add(author);

            authorRepository.save(author);
            bookRepository.save(book);

            Author author1 = new Author("George", "Orwell");
            Book book1 = new Book("1980", "10284374523");

            author1.getBooks().add(book1);
            book1.getAuthors().add(author1);

            authorRepository.save(author1);
            bookRepository.save(book1);

            System.out.println("Started Bootstrap");
            System.out.println("Number of books: " + bookRepository.count());

            Publisher publisher = new Publisher("National Bookstore", "Address Line",
                    "Cavite", "Indang", "4122");

            publisher.getBooks().add(book);
            publisher.getBooks().add(book1);

            publisherRepository.save(publisher);

            System.out.println("Number of publisher: " + publisherRepository.count());
    }
}
