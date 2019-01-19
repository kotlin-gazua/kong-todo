package com.todo

import com.todo.domain.Content
import com.todo.repository.ContentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
class ContentsController {

    @Autowired
    lateinit var contentsRepository: ContentsRepository

    @GetMapping("/ping")
    fun pong() = "pong"

    @PostMapping("/content")
    fun addContent(@RequestBody content: Content): Content = contentsRepository.save(content)

    @PutMapping("/content/{seq}")
    fun updateContent(@PathVariable seq: Long, @RequestBody newContent: Content): ResponseEntity<Content> {

        return contentsRepository.findById(seq).map { data ->
            val updatedContent: Content = data
                .copy(content = newContent.content, date = LocalDateTime.now())
            ResponseEntity.ok().body(contentsRepository.save(updatedContent))
        }.orElse(ResponseEntity.notFound().build())

    }

    @GetMapping("/contents")
    fun getContents(): MutableIterable<Content> = contentsRepository.findAll()

}
