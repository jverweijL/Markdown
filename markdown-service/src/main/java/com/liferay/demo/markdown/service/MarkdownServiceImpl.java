package com.liferay.demo.markdown.service;

import com.liferay.demo.markdown.api.MarkdownService;
import com.vladsch.flexmark.util.options.MutableDataSet;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

import org.osgi.service.component.annotations.Component;

/**
 * @author jverweij
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = MarkdownService.class
)
public class MarkdownServiceImpl implements MarkdownService {
	@Override
	public String basicrenderer(String text) {
		MutableDataSet options = new MutableDataSet();

		// uncomment to set optional extensions
		//options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));

		// uncomment to convert soft-breaks to hard breaks
		//options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();

		// You can re-use parser and renderer instances
		Node document = parser.parse(text);
		return renderer.render(document);
	}


}