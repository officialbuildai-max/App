package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.nodes.Element;

/* loaded from: classes7.dex */
public abstract class Selector {

    /* loaded from: classes7.dex */
    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Elements a(Collection collection, Collection collection2) {
        Elements elements = new Elements();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            Iterator it2 = collection2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    elements.add(element);
                    break;
                }
                if (element.equals((Element) it2.next())) {
                    break;
                }
            }
        }
        return elements;
    }

    public static Elements b(String str, Iterable iterable) {
        org.jsoup.helper.d.h(str);
        org.jsoup.helper.d.j(iterable);
        c t11 = e.t(str);
        ArrayList arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Iterator<Element> it2 = d(t11, (Element) it.next()).iterator();
            while (it2.hasNext()) {
                Element next = it2.next();
                if (!identityHashMap.containsKey(next)) {
                    arrayList.add(next);
                    identityHashMap.put(next, Boolean.TRUE);
                }
            }
        }
        return new Elements((List<Element>) arrayList);
    }

    public static Elements c(String str, Element element) {
        org.jsoup.helper.d.h(str);
        return d(e.t(str), element);
    }

    public static Elements d(c cVar, Element element) {
        org.jsoup.helper.d.j(cVar);
        org.jsoup.helper.d.j(element);
        return a.a(cVar, element);
    }
}
