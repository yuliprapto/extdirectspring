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
package ch.ralscha.extdirectspring.generator;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class GeneratorTestUtil {

	public static void compareModelString(String expectedValue, String value, boolean debug) {
		if (debug) {
			assertThat(value.replaceAll("\\r?\\n", "\n")).isEqualTo(expectedValue.replaceAll("\\r?\\n", "\n"));
		} else {
			assertThat(value).isEqualTo(expectedValue.replaceAll("\\r?\\n", "").replace(" ", ""));
		}
	}

	public static void compareExtJs4Model(String expectedFile, String value, boolean debug) {
		try {
			String expectedValue = IOUtils.toString(GeneratorTestUtil.class.getResourceAsStream(expectedFile));
			compareModelString(expectedValue, value, debug);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void compareTouch2Model(String expectedFile, String value, boolean debug) {
		try {
			String expectedValue = IOUtils.toString(GeneratorTestUtil.class.getResourceAsStream(expectedFile));
			compareModelString(expectedValue, value, debug);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
