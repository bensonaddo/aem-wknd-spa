package com.adobe.aem.guides.wknd.spa.react.core.models.impl;

import java.util.Calendar;
import javax.annotation.PostConstruct;
import com.adobe.aem.guides.wknd.spa.react.core.models.CustomText;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.models.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { CustomText.class,
        ComponentExporter.class }, resourceType = CustomTextImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CustomTextImpl implements CustomText {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    static final String RESOURCE_TYPE = "wknd-spa-react/components/text";

    @Self
    private SlingHttpServletRequest request;

    @ValueMapValue
    private String alignment;

    @ValueMapValue
    private String text;

    /***
     * Made available via https://docs.adobe.com/content/help/en/experience-manager-htl/using/htl/global-objects.html#java-backed-objects
     */
    @ScriptVariable
    PageManager pageManager;

    @PostConstruct
    // PostConstructs are called after all the injection has occurred, but before the Model object is returned for use.
    public void initModel() {
        logger.debug("--- Text initModel() alignment 555: " + this.alignment);
    }

    @Override
    public String getAlignment() {
        logger.debug("--- Text getAlignment(): " + this.alignment);

        return null != this.alignment ? this.alignment : null;
    }

    @Override
    public String getDescription() {
        String description = (null != this.text) ? this.text : null;

        logger.debug("--- Text getDescription(): " + description + " | this.text: " + this.text);

        return description;
    }

    @Override
    public String getExportedType() {
        logger.info("--- Text getExportedType(): " + CustomTextImpl.RESOURCE_TYPE);

        return CustomTextImpl.RESOURCE_TYPE;
    }
}