package com.liferay.demo.markdown.contributor;

import com.liferay.demo.markdown.api.MarkdownService;
import com.liferay.portal.kernel.template.TemplateContextContributor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author jverweij
 */
@Component(
        immediate = true,
        property = "type=" + TemplateContextContributor.TYPE_GLOBAL,
        service = TemplateContextContributor.class
)
public class MarkdownTemplateContextContributor
        implements TemplateContextContributor {
    @Override
    public void prepare(Map<String, Object> contextObjects, HttpServletRequest httpServletRequest) {
        contextObjects.put("markdownService", _markdownService);
    }

    @Reference
    private MarkdownService _markdownService;
}
