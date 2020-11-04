package com.liferay.demo.markdown.service;

import com.liferay.demo.markdown.api.MarkdownService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.vladsch.flexmark.util.ast.Node;
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
		_log.debug("Raw text: " + text);

		MutableDataSet options = new MutableDataSet();
		// uncomment to set optional extensions
		//options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));
		options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

		_log.debug("Options: " + options.toString());

		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();

		// You can re-use parser and renderer instances
		Node document = parser.parse(text);
		_log.debug("Parsed text: " + document);
		return renderer.render(document);
	}

	private static final Log _log = LogFactoryUtil.getLog(MarkdownServiceImpl.class);

}