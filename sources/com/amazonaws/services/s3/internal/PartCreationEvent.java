package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.OnFileDelete;
import java.io.File;

/* loaded from: classes2.dex */
public class PartCreationEvent {

    /* renamed from: a, reason: collision with root package name */
    private final File f18732a;

    /* renamed from: b, reason: collision with root package name */
    private final int f18733b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f18734c;

    /* renamed from: d, reason: collision with root package name */
    private final OnFileDelete f18735d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PartCreationEvent(File file, int i11, boolean z10, OnFileDelete onFileDelete) {
        if (file == null) {
            throw new IllegalArgumentException("part must not be specified");
        }
        this.f18732a = file;
        this.f18733b = i11;
        this.f18734c = z10;
        this.f18735d = onFileDelete;
    }

    public OnFileDelete a() {
        return this.f18735d;
    }

    public File b() {
        return this.f18732a;
    }

    public int c() {
        return this.f18733b;
    }

    public boolean d() {
        return this.f18734c;
    }
}
