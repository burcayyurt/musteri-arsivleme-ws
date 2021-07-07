/*
package NoterlerBirligi.islemsorguservice;

import NoterlerBirligi.islemsorguservice.dto.IslemDTO;
import NoterlerBirligi.islemsorguservice.service.NpsIslemSorguService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class IslemSorguServiceApplicationTests {

	@Autowired
	private NpsIslemSorguService npsIslemSorguService;

	@Test
	@Transactional
	@Rollback
	public void islemKontrol() {

		IslemDTO islemDto = new IslemDTO();
		islemDto.setNoterlikId(5427);
		islemDto.setYevmiyeNo("605327");

		npsIslemSorguService.islemGetirById(islemDto.getNoterlikId(),islemDto.getYevmiyeNo(),islemDto.getYevmiyeTarihi());

	}

}
*/
