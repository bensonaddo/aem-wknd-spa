import DOMPurify from 'dompurify';

/**
 * @description Global util methods
 * @author dzung.vo@gmfinancial.com
 * @date 2023-05-09
 */

/**
 * @description Purify DOM HTML tags
 * @param {string} htmlTag - String with <a> tag embedded (e.g. Please <a class="tomato" href="${urlPlaceholder}"> click here </a>)
 * @param {string} selector - Placeholder to replace
 * @param {string} htmlInput - Url
 * @return {*}  {string}
 */
export const purifyHtmlContent = (htmlTag, selector, htmlInput) => {
    //console.log("--- purifyHtmlContent(): " + selector + " | htmlInput: " + htmlInput);

    var $element = <span className={selector} dangerouslySetInnerHTML={{__html: DOMPurify.sanitize(htmlInput)}}></span>;

    return $element;
};

export const round = (value, precision) => {
    var multiplier = Math.pow(10, precision || 0);
    return Math.round(value * multiplier) / multiplier;
};