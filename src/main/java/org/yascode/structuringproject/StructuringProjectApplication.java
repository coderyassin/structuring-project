package org.yascode.structuringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.yascode.structuringproject.domain.model.Category;
import org.yascode.structuringproject.domain.model.Note;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class StructuringProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StructuringProjectApplication.class, args);
		Note note$1 = context.getBean(Note.class);
		Category category$1 = context.getBean(Category.class);

		System.out.println(note$1.getTitle());
		System.out.println(note$1.getContent());
		System.out.println(note$1.getCreateAt());
		System.out.println(category$1.getName());
	}

}
