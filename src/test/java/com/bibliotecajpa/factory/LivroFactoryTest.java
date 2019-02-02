package com.bibliotecajpa.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.bibliotecajpa.dto.LivroDTO;
import com.bibliotecajpa.model.Livro;

@RunWith(MockitoJUnitRunner.class)
public class LivroFactoryTest {

	@InjectMocks
	private LivroFactory livroFactory;
	

	
	@Test
	public void test2() {
		LivroDTO livroDTO = new LivroDTO("Senhor dos Aneis - A sociedade do anel", "Livro do senhor dos aneis", "J. R. R. Tolkien", "Abril",2);
		Livro expected = new Livro("Senhor dos Aneis - A sociedade do anel", "Livro do senhor dos aneis", "J. R. R. Tolkien", "Abril",2);
		Livro actual = livroFactory.getInstance(livroDTO);
		assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
	}
	
	@Test
	public void test3() {
		LivroDTO livroDTO = new LivroDTO("", "Livro do senhor dos aneis", "J. R. R. Tolkien", "Abril",2);
		assertThatThrownBy(() -> livroFactory.getInstance(livroDTO))
	        .isInstanceOf(IllegalArgumentException.class)
	        .hasMessage("Campo nome não pode ser vazio.");
	}
	
	@Test
	public void test4() {
		LivroDTO livroDTO = new LivroDTO(null, "Livro do senhor dos aneis", "J. R. R. Tolkien", "Abril",2);
		assertThatThrownBy(() -> livroFactory.getInstance(livroDTO))
	        .isInstanceOf(IllegalArgumentException.class)
	        .hasMessage("Campo nome não pode ser nulo.");
	}
	
}
