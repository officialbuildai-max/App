package org.jsoup.select;

import org.jsoup.nodes.j;

/* loaded from: classes7.dex */
public interface NodeFilter {

    /* loaded from: classes7.dex */
    public enum FilterResult {
        CONTINUE,
        SKIP_CHILDREN,
        SKIP_ENTIRELY,
        REMOVE,
        STOP
    }

    FilterResult a(j jVar, int i11);

    FilterResult b(j jVar, int i11);
}
