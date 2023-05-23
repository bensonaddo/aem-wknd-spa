package com.adobe.aem.guides.wknd.spa.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;

public interface CustomText extends ComponentExporter {
    public String getAlignment();
    public String getDescription();
}