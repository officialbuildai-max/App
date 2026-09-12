package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.b0;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes3.dex */
public final class d implements b0.a {

    /* renamed from: a, reason: collision with root package name */
    private final b0.a f25638a;

    /* renamed from: b, reason: collision with root package name */
    private final List f25639b;

    public d(b0.a aVar, List list) {
        this.f25638a = aVar;
        this.f25639b = list;
    }

    @Override // com.google.android.exoplayer2.upstream.b0.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c parse(Uri uri, InputStream inputStream) {
        c cVar = (c) this.f25638a.parse(uri, inputStream);
        List list = this.f25639b;
        return (list == null || list.isEmpty()) ? cVar : (c) cVar.copy(this.f25639b);
    }
}
