package com.google.android.material.color;

import android.support.v4.media.session.c;
import java.util.Comparator;

/* loaded from: classes4.dex */
class ColorResourcesTableCreator$1 implements Comparator<a> {
    ColorResourcesTableCreator$1() {
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(a aVar, a aVar2) {
        return a.a(aVar) - a.a(aVar2);
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
        c.a(aVar);
        c.a(aVar2);
        return compare2((a) null, (a) null);
    }
}
