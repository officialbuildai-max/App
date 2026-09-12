package com.bykv.vk.openvk.preload.a;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
final class a extends r<Date> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? extends Date> f20390a;

    /* renamed from: b, reason: collision with root package name */
    private final List<DateFormat> f20391b;

    public a(Class<? extends Date> cls, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        this.f20391b = arrayList;
        this.f20390a = a(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i11, i12, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i11, i12));
        }
        if (com.bykv.vk.openvk.preload.a.b.d.b()) {
            arrayList.add(com.bykv.vk.openvk.preload.falconx.a.a.a(i11, i12));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.f20391b = arrayList;
        this.f20390a = a(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    private Date a(String str) {
        synchronized (this.f20391b) {
            Iterator<DateFormat> it = this.f20391b.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.bykv.vk.openvk.preload.a.b.a.a.a.a(str, new ParsePosition(0));
            } catch (ParseException e11) {
                throw new p(str, e11);
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final /* synthetic */ Date a(com.bykv.vk.openvk.preload.a.d.a aVar) throws IOException {
        if (aVar.f() == com.bykv.vk.openvk.preload.a.d.b.NULL) {
            aVar.j();
            return null;
        }
        Date a11 = a(aVar.h());
        Class<? extends Date> cls = this.f20390a;
        if (cls == Date.class) {
            return a11;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a11.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a11.getTime());
        }
        throw new AssertionError();
    }

    @Override // com.bykv.vk.openvk.preload.a.r
    public final /* synthetic */ void a(com.bykv.vk.openvk.preload.a.d.c cVar, Date date) throws IOException {
        Date date2 = date;
        if (date2 == null) {
            cVar.h();
            return;
        }
        synchronized (this.f20391b) {
            cVar.b(this.f20391b.get(0).format(date2));
        }
    }

    public final String toString() {
        DateFormat dateFormat = this.f20391b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
