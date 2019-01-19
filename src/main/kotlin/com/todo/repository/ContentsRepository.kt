package com.todo.repository

import com.todo.domain.Content
import org.springframework.data.repository.CrudRepository

interface ContentsRepository : CrudRepository<Content, Long>
