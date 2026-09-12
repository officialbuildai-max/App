package com.transsion.transfer.androidasync.http;

import com.transsion.transfer.androidasync.util.TaggedList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes6.dex */
public class Headers {

    /* renamed from: a, reason: collision with root package name */
    final Multimap f55403a = new Multimap() { // from class: com.transsion.transfer.androidasync.http.Headers.1
        @Override // com.transsion.transfer.androidasync.http.Multimap
        protected List<String> newList() {
            return new TaggedList();
        }
    };

    public Headers a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.US);
        this.f55403a.add(lowerCase, str2);
        ((TaggedList) this.f55403a.get(lowerCase)).tagNull(str);
        return this;
    }

    public Headers b(String str) {
        if (str != null) {
            String[] split = str.trim().split(":", 2);
            if (split.length == 2) {
                a(split[0].trim(), split[1].trim());
            } else {
                a(split[0].trim(), "");
            }
        }
        return this;
    }

    public String c(String str) {
        return this.f55403a.getString(str.toLowerCase(Locale.US));
    }

    public String d(String str) {
        List e11 = e(str.toLowerCase(Locale.US));
        if (e11 == null || e11.size() == 0) {
            return null;
        }
        return (String) e11.get(0);
    }

    public List e(String str) {
        return this.f55403a.remove(str.toLowerCase(Locale.US));
    }

    public Headers f(String str, String str2) {
        if (str2 != null && (str2.contains("\n") || str2.contains("\r"))) {
            throw new IllegalArgumentException("value must not contain a new line or line feed");
        }
        String lowerCase = str.toLowerCase(Locale.US);
        this.f55403a.put(lowerCase, str2);
        ((TaggedList) this.f55403a.get(lowerCase)).tagNull(str);
        return this;
    }

    public String g(String str) {
        return h().insert(0, str + "\r\n").toString();
    }

    public StringBuilder h() {
        StringBuilder sb2 = new StringBuilder(256);
        Iterator<String> it = this.f55403a.keySet().iterator();
        while (it.hasNext()) {
            TaggedList taggedList = (TaggedList) this.f55403a.get(it.next());
            Iterator<T> it2 = taggedList.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                sb2.append((String) taggedList.tag());
                sb2.append(": ");
                sb2.append(str);
                sb2.append("\r\n");
            }
        }
        sb2.append("\r\n");
        return sb2;
    }

    public String toString() {
        return h().toString();
    }
}
