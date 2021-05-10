package nowowiejski.m.myapp.core.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object LinkHelper {

    fun extractUrls(text: String): Pair<String, String?> {
        val containedUrls = mutableListOf<String>()
        val urlRegex =
            "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)"
        val pattern: Pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE)
        val urlMatcher: Matcher = pattern.matcher(text)
        while (urlMatcher.find()) {
            containedUrls.add(
                text.substring(
                    urlMatcher.start(0),
                    urlMatcher.end(0)
                )
            )
        }
        val textWithoutUrl =  text.replace(containedUrls.first(), "")
        return Pair(textWithoutUrl, containedUrls.firstOrNull())
    }

    fun pullLinks(text: String): List<String> {
        val links = mutableListOf<String>()
        val regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&@#/%=~_()|]"
        val p: Pattern = Pattern.compile(regex)
        val m: Matcher = p.matcher(text)
        while (m.find()) {
            var urlStr: String = m.group()
            if (urlStr.startsWith("(") && urlStr.endsWith(")")) {
                urlStr = urlStr.substring(1, urlStr.length - 1)
            }
            links.add(urlStr)
        }
        return links
    }
}