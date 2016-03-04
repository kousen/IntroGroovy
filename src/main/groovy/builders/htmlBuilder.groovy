package builders

import groovy.xml.MarkupBuilder

def writer = new FileWriter('department.html')
def builder = new MarkupBuilder(writer)
builder.html {
	head {
		title "IT Employees"
	}
	body {
		h2 "IT"
		table (border:1) {
			(0..3).each { num ->
				tr {
					td num
					td "Employee $num"
				}
			}
		}
	}
}

println new File('department.html').text