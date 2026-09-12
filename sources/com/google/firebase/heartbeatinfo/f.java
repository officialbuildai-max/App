package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.os.Build;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.c;
import com.google.firebase.datastorage.JavaDataStorage;
import gc.o;
import gc.p;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f31926b = androidx.datastore.preferences.core.e.f("fire-global");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f31927c = androidx.datastore.preferences.core.e.f("fire-count");

    /* renamed from: d, reason: collision with root package name */
    private static final c.a f31928d = androidx.datastore.preferences.core.e.g("last-used-date");

    /* renamed from: a, reason: collision with root package name */
    private final JavaDataStorage f31929a;

    public f(Context context, String str) {
        this.f31929a = new JavaDataStorage(context, "FirebaseHeartBeat" + str);
    }

    private synchronized long e(MutablePreferences mutablePreferences) {
        long j11;
        try {
            long longValue = ((Long) com.google.firebase.datastorage.c.a(mutablePreferences, f31927c, 0L)).longValue();
            String str = "";
            Set hashSet = new HashSet();
            String str2 = null;
            for (Map.Entry entry : mutablePreferences.a().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set<String> set = (Set) entry.getValue();
                    for (String str3 : set) {
                        if (str2 != null && str2.compareTo(str3) <= 0) {
                        }
                        str = ((c.a) entry.getKey()).a();
                        hashSet = set;
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet2 = new HashSet(hashSet);
            hashSet2.remove(str2);
            mutablePreferences.i(androidx.datastore.preferences.core.e.h(str), hashSet2);
            j11 = longValue - 1;
            mutablePreferences.i(f31927c, Long.valueOf(j11));
        } catch (Throwable th2) {
            throw th2;
        }
        return j11;
    }

    private synchronized String h(long j11) {
        Instant instant;
        ZoneOffset zoneOffset;
        OffsetDateTime atOffset;
        LocalDateTime localDateTime;
        DateTimeFormatter dateTimeFormatter;
        String format;
        if (Build.VERSION.SDK_INT < 26) {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j11));
        }
        instant = new Date(j11).toInstant();
        zoneOffset = ZoneOffset.UTC;
        atOffset = instant.atOffset(zoneOffset);
        localDateTime = atOffset.toLocalDateTime();
        dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        format = localDateTime.format(dateTimeFormatter);
        return format;
    }

    private synchronized c.a i(MutablePreferences mutablePreferences, String str) {
        for (Map.Entry entry : mutablePreferences.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return androidx.datastore.preferences.core.e.h(((c.a) entry.getKey()).a());
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit k(MutablePreferences mutablePreferences) {
        Set a11;
        long j11 = 0;
        for (Map.Entry entry : mutablePreferences.a().entrySet()) {
            if (entry.getValue() instanceof Set) {
                c.a aVar = (c.a) entry.getKey();
                Set set = (Set) entry.getValue();
                String h11 = h(System.currentTimeMillis());
                if (set.contains(h11)) {
                    a11 = o.a(new Object[]{h11});
                    mutablePreferences.i(aVar, a11);
                    j11++;
                } else {
                    mutablePreferences.h(aVar);
                }
            }
        }
        if (j11 == 0) {
            mutablePreferences.h(f31927c);
            return null;
        }
        mutablePreferences.i(f31927c, Long.valueOf(j11));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit l(String str, MutablePreferences mutablePreferences) {
        mutablePreferences.i(f31928d, str);
        p(mutablePreferences, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit m(String str, String str2, c.a aVar, MutablePreferences mutablePreferences) {
        c.a aVar2 = f31928d;
        if (((String) com.google.firebase.datastorage.c.a(mutablePreferences, aVar2, "")).equals(str)) {
            c.a i11 = i(mutablePreferences, str);
            if (i11 == null || i11.a().equals(str2)) {
                return null;
            }
            u(mutablePreferences, aVar, str);
            return null;
        }
        c.a aVar3 = f31927c;
        long longValue = ((Long) com.google.firebase.datastorage.c.a(mutablePreferences, aVar3, 0L)).longValue();
        if (longValue + 1 == 30) {
            longValue = e(mutablePreferences);
        }
        HashSet hashSet = new HashSet((Collection) com.google.firebase.datastorage.c.a(mutablePreferences, aVar, new HashSet()));
        hashSet.add(str);
        mutablePreferences.i(aVar, hashSet);
        mutablePreferences.i(aVar3, Long.valueOf(longValue + 1));
        mutablePreferences.i(aVar2, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit n(long j11, MutablePreferences mutablePreferences) {
        mutablePreferences.i(f31926b, Long.valueOf(j11));
        return null;
    }

    private synchronized void p(MutablePreferences mutablePreferences, String str) {
        try {
            c.a i11 = i(mutablePreferences, str);
            if (i11 == null) {
                return;
            }
            HashSet hashSet = new HashSet((Collection) com.google.firebase.datastorage.c.a(mutablePreferences, i11, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                mutablePreferences.h(i11);
            } else {
                mutablePreferences.i(i11, hashSet);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private synchronized void u(MutablePreferences mutablePreferences, c.a aVar, String str) {
        p(mutablePreferences, str);
        HashSet hashSet = new HashSet((Collection) com.google.firebase.datastorage.c.a(mutablePreferences, aVar, new HashSet()));
        hashSet.add(str);
        mutablePreferences.i(aVar, hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void f() {
        this.f31929a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit k11;
                k11 = f.this.k((MutablePreferences) obj);
                return k11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List g() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            String h11 = h(System.currentTimeMillis());
            for (Map.Entry entry : this.f31929a.h().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(h11);
                    if (!hashSet.isEmpty()) {
                        arrayList.add(p.a(((c.a) entry.getKey()).a(), new ArrayList(hashSet)));
                    }
                }
            }
            t(System.currentTimeMillis());
        } catch (Throwable th2) {
            throw th2;
        }
        return arrayList;
    }

    synchronized boolean j(long j11, long j12) {
        return h(j11).equals(h(j12));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void o() {
        final String h11 = h(System.currentTimeMillis());
        this.f31929a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l11;
                l11 = f.this.l(h11, (MutablePreferences) obj);
                return l11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean q(long j11) {
        return r(f31926b, j11);
    }

    synchronized boolean r(c.a aVar, long j11) {
        if (j(((Long) this.f31929a.j(aVar, -1L)).longValue(), j11)) {
            return false;
        }
        this.f31929a.k(aVar, Long.valueOf(j11));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void s(long j11, final String str) {
        final String h11 = h(j11);
        final c.a h12 = androidx.datastore.preferences.core.e.h(str);
        this.f31929a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit m11;
                m11 = f.this.m(h11, str, h12, (MutablePreferences) obj);
                return m11;
            }
        });
    }

    synchronized void t(final long j11) {
        this.f31929a.g(new Function1() { // from class: com.google.firebase.heartbeatinfo.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n11;
                n11 = f.n(j11, (MutablePreferences) obj);
                return n11;
            }
        });
    }
}
