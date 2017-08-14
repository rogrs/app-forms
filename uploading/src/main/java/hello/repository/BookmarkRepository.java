package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.model.Bookmark;

import java.util.Collection;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Collection<Bookmark> findByAccountUsername(String username);
}