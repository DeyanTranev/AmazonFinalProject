package amazon.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SingleProductController {

	@RequestMapping(value="/single-product", method = RequestMethod.GET)
	public String cartSingleProductCtrl() {
		return "single-product";
	}
}
