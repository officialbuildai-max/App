package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
class j {

    /* renamed from: d, reason: collision with root package name */
    private static final FilenameFilter f31243d = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.common.h
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean d11;
            d11 = j.d(file, str);
            return d11;
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final Comparator f31244e = new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.i
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int e11;
            e11 = j.e((File) obj, (File) obj2);
            return e11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final vb.g f31245a;

    /* renamed from: b, reason: collision with root package name */
    private String f31246b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f31247c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(vb.g gVar) {
        this.f31245a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(File file, String str) {
        return str.startsWith("aqs.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(File file, File file2) {
        return Long.compare(file2.lastModified(), file.lastModified());
    }

    private static void f(vb.g gVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            gVar.q(str, "aqs." + str2).createNewFile();
        } catch (IOException e11) {
            ob.g.f().l("Failed to persist App Quality Sessions session id.", e11);
        }
    }

    static String g(vb.g gVar, String str) {
        List r11 = gVar.r(str, f31243d);
        if (!r11.isEmpty()) {
            return ((File) Collections.min(r11, f31244e)).getName().substring(4);
        }
        ob.g.f().k("Unable to read App Quality Sessions session id.");
        return null;
    }

    public synchronized String c(String str) {
        if (Objects.equals(this.f31246b, str)) {
            return this.f31247c;
        }
        return g(this.f31245a, str);
    }

    public synchronized void h(String str) {
        if (!Objects.equals(this.f31247c, str)) {
            f(this.f31245a, this.f31246b, str);
            this.f31247c = str;
        }
    }

    public synchronized void i(String str) {
        if (!Objects.equals(this.f31246b, str)) {
            f(this.f31245a, str, this.f31247c);
            this.f31246b = str;
        }
    }
}
