package com.example.pastebinS;

import com.example.pastebinS.Paste.Paste;
import com.example.pastebinS.PasteRepository.PasteRepository;
import com.example.pastebinS.PasteService.PasteService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PastebinSApplicationTests {
	@Autowired
	PasteRepository pasteRepository;

	@Test
	@Order(1)
	public void testCreate() {
		Paste p = new Paste();
		p.setTitle("title");
		p.setText("text");
		pasteRepository.save(p);
		assertNotNull(pasteRepository.findById(p.getId()));
	}

	@Test
	@Order(2)
	public void testRead() {
		List<Paste> list = pasteRepository.findAll();
		Assertions.assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testOnePaste() {
		Paste p = pasteRepository.findById(3).get();
		assertEquals("title", p.getTitle());
	}
}
