package org.jsoup.nodes;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;

/* loaded from: classes7.dex */
public class a implements Map.Entry, Cloneable {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f71872d = {"allowfullscreen", TmcConstants.KEY_ASYNC, "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", MRAIDPresenter.OPEN, "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};

    /* renamed from: a, reason: collision with root package name */
    private String f71873a;

    /* renamed from: b, reason: collision with root package name */
    private String f71874b;

    /* renamed from: c, reason: collision with root package name */
    b f71875c;

    public a(String str, String str2) {
        this(str, str2, null);
    }

    public a(String str, String str2, b bVar) {
        org.jsoup.helper.d.j(str);
        this.f71873a = str.trim();
        org.jsoup.helper.d.h(str);
        this.f71874b = str2;
        this.f71875c = bVar;
    }

    protected static void g(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) {
        appendable.append(str);
        if (k(str, str2, outputSettings)) {
            return;
        }
        appendable.append("=\"");
        Entities.e(appendable, b.j(str2), outputSettings, true, false, false);
        appendable.append('\"');
    }

    protected static boolean i(String str) {
        return Arrays.binarySearch(f71872d, str) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean k(String str, String str2, Document.OutputSettings outputSettings) {
        return outputSettings.m() == Document.OutputSettings.Syntax.html && (str2 == null || (("".equals(str2) || str2.equalsIgnoreCase(str)) && i(str)));
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // java.util.Map.Entry
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f71873a;
    }

    @Override // java.util.Map.Entry
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return this.f71874b;
    }

    public String e() {
        StringBuilder sb2 = new StringBuilder();
        try {
            f(sb2, new Document("").g1());
            return sb2.toString();
        } catch (IOException e11) {
            throw new SerializationException(e11);
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f71873a;
        if (str == null ? aVar.f71873a != null : !str.equals(aVar.f71873a)) {
            return false;
        }
        String str2 = this.f71874b;
        String str3 = aVar.f71874b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Appendable appendable, Document.OutputSettings outputSettings) {
        g(this.f71873a, this.f71874b, appendable, outputSettings);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.f71873a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f71874b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String setValue(String str) {
        int t11;
        String n11 = this.f71875c.n(this.f71873a);
        b bVar = this.f71875c;
        if (bVar != null && (t11 = bVar.t(this.f71873a)) != -1) {
            this.f71875c.f71879c[t11] = str;
        }
        this.f71874b = str;
        return n11;
    }

    public String toString() {
        return e();
    }
}
