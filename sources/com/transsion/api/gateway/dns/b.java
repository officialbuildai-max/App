package com.transsion.api.gateway.dns;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f42572a;

    /* renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList f42573b = new CopyOnWriteArrayList();

    public b(b bVar) {
        this.f42572a = bVar.f42572a;
        Iterator it = bVar.f42573b.iterator();
        while (it.hasNext()) {
            this.f42573b.add(new d((d) it.next()));
        }
    }

    public b(String str) {
        this.f42572a = str;
    }

    public void a(String str, int i11) {
        d dVar;
        synchronized (b.class) {
            try {
                Iterator it = this.f42573b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    } else {
                        dVar = (d) it.next();
                        if (dVar.f42576b.equals(str)) {
                        }
                    }
                }
            } finally {
            }
        }
        synchronized (b.class) {
            if (dVar == null) {
                try {
                    this.f42573b.add(new d(str, i11));
                } finally {
                }
            }
        }
    }
}
