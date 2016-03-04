package builders

import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import javax.swing.WindowConstants as WC

SwingBuilder builder = new SwingBuilder()
def frame = builder.frame(title:'Hello, Groovy!', visible: true,
		size:[200,100],	defaultCloseOperation:WC.EXIT_ON_CLOSE) {
	panel(layout:new BL()) {
		def txt = textField(constraints:BL.NORTH,'Enter text here')
		def lab = label(constraints:BL.CENTER,'Text')
		button(constraints: BL.SOUTH, 'Move Text',
			actionPerformed: { lab.text = txt.text })
		txt.actionPerformed = { lab.text = txt.text }
	}
}
