/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package scripts

import org.junit.jupiter.api.Test

class ScriptTests {
	String baseDir = 'src/main/groovy/'
	GroovyShell shell = new GroovyShell()

	@Test
	void testClosures() {
		shell.evaluate(new File("$baseDir/closurespackage/closures.groovy"))
	}

	@Test
	void testCollections() {
		shell.evaluate(new File("$baseDir/collections/lists.groovy"))
		shell.evaluate(new File("$baseDir/collections/maps.groovy"))
		shell.evaluate(new File("$baseDir/collections/ranges.groovy"))
	}

	@Test
	void testConditionals() {
		shell.evaluate(new File("$baseDir/conditionals/conditionals.groovy"))
		shell.evaluate(new File("$baseDir/conditionals/loops.groovy"))
	}

	@Test
	void testNumbers() {
		shell.evaluate(new File("$baseDir/intro/numbers.groovy"))
	}

	@Test
	void testIo() {
		shell.evaluate(new File("$baseDir/io/files.groovy"))
	}

	@Test
    void testDb() {
        shell.evaluate(new File("$baseDir/db/products.groovy"))
    }

	@Test
	void testStrings() {
		shell.evaluate(new File("$baseDir/groovystrings/strings.groovy"))
	}

	@Test
    void testMetaprogramming() {
        shell.evaluate(new File("$baseDir/metaprogramming/print_currency.groovy"))
    }

	@Test
	void testXml() {
		shell.evaluate(new File("$baseDir/xml/parsing.groovy"))
		shell.evaluate(new File("$baseDir/xml/namespaces.groovy"))
	}

}
