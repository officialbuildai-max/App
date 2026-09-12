package org.apache.tools.ant.taskdefs;

import java.net.URL;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d implements Enumeration {

    /* renamed from: a, reason: collision with root package name */
    private boolean f71473a = true;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ URL f71474b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ e f71475c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar, URL url) {
        this.f71475c = eVar;
        this.f71474b = url;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f71473a;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        if (!this.f71473a) {
            throw new NoSuchElementException();
        }
        this.f71473a = false;
        return this.f71474b;
    }
}
