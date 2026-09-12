package ow;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f72312a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final Gson f72313b = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private a() {
    }

    public final String a(Object obj) {
        if (obj != null) {
            try {
            } catch (Exception unused) {
                return "";
            }
        }
        return new Gson().toJson(obj);
    }
}
