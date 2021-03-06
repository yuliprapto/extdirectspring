/**
 * Copyright 2010-2012 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.ralscha.extdirectspring_itest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;

@Controller
@RequestMapping("/exceptionTest")
public class ExceptionFormPostController {

	@ExtDirectMethod(value = ExtDirectMethodType.FORM_POST, group = "itest_upload")
	@RequestMapping(value = "/throwIt", method = RequestMethod.POST)
	public void throwAException(@SuppressWarnings("unused") HttpServletRequest request) {
		throw new NullPointerException("a null pointer");
	}

	// This only works with Spring 3.1
	// @ExceptionHandler(Exception.class)
	// public void handleException(HttpServletRequest request,
	// HttpServletResponse response) {
	// ExtDirectResponseBuilder builder = new ExtDirectResponseBuilder(request,
	// response);
	// builder.unsuccessful();
	//
	// ExtDirectResponse response = builder.build();
	// response.setType("exception");
	// response.setMessage("Server Error");
	// return response;
	// }

}
