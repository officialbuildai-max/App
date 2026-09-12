package rb;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final Charset f74372b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final vb.g f74373a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends JSONObject {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f74374a;

        a(String str) {
            this.f74374a = str;
            put("userId", str);
        }
    }

    public f(vb.g gVar) {
        this.f74373a = gVar;
    }

    private static Map e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, p(jSONObject, next));
        }
        return hashMap;
    }

    private static List f(String str) {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            String string = jSONArray.getString(i11);
            try {
                arrayList.add(i.a(string));
            } catch (Exception e11) {
                ob.g.f().l("Failed de-serializing rollouts state. " + string, e11);
            }
        }
        return arrayList;
    }

    private String g(String str) {
        return p(new JSONObject(str), "userId");
    }

    private static String h(Map map) {
        return new JSONObject(map).toString();
    }

    private static String l(List list) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < list.size(); i11++) {
            try {
                jSONArray.put(new JSONObject(i.f74400a.b(list.get(i11))));
            } catch (JSONException e11) {
                ob.g.f().l("Exception parsing rollout assignment!", e11);
            }
        }
        hashMap.put("rolloutsState", jSONArray);
        return new JSONObject(hashMap).toString();
    }

    private static void m(File file) {
        if (file.exists() && file.delete()) {
            ob.g.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static void n(File file, String str) {
        if (file.exists() && file.delete()) {
            ob.g.f().g(String.format("Deleted corrupt file: %s\nReason: %s", file.getAbsolutePath(), str));
        }
    }

    private static String o(String str) {
        return new a(str).toString();
    }

    private static String p(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        return this.f74373a.q(str, "internal-keys");
    }

    public File b(String str) {
        return this.f74373a.q(str, "keys");
    }

    public File c(String str) {
        return this.f74373a.q(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f74373a.q(str, "user-data");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    public Map i(String str, boolean z10) {
        Throwable th2;
        FileInputStream fileInputStream;
        Exception e11;
        File a11 = z10 ? a(str) : b(str);
        if (!a11.exists() || a11.length() == 0) {
            n(a11, "The file has a length of zero for session: " + str);
            return Collections.emptyMap();
        }
        try {
            try {
                fileInputStream = new FileInputStream(a11);
                try {
                    Map e12 = e(CommonUtils.A(fileInputStream));
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return e12;
                } catch (Exception e13) {
                    e11 = e13;
                    ob.g.f().l("Error deserializing user metadata.", e11);
                    m(a11);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                }
            } catch (Throwable th3) {
                th2 = th3;
                CommonUtils.f(r1, "Failed to close user metadata file.");
                throw th2;
            }
        } catch (Exception e14) {
            fileInputStream = null;
            e11 = e14;
        } catch (Throwable th4) {
            ?? r12 = 0;
            th2 = th4;
            CommonUtils.f(r12, "Failed to close user metadata file.");
            throw th2;
        }
    }

    public List j(String str) {
        FileInputStream fileInputStream;
        File c11 = c(str);
        if (!c11.exists() || c11.length() == 0) {
            n(c11, "The file has a length of zero for session: " + str);
            return Collections.emptyList();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(c11);
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            List f11 = f(CommonUtils.A(fileInputStream));
            ob.g.f().b("Loaded rollouts state:\n" + f11 + "\nfor session " + str);
            CommonUtils.f(fileInputStream, "Failed to close rollouts state file.");
            return f11;
        } catch (Exception e12) {
            e = e12;
            fileInputStream2 = fileInputStream;
            ob.g.f().l("Error deserializing rollouts state.", e);
            m(c11);
            CommonUtils.f(fileInputStream2, "Failed to close rollouts state file.");
            return Collections.emptyList();
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            CommonUtils.f(fileInputStream2, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public String k(String str) {
        FileInputStream fileInputStream;
        File d11 = d(str);
        FileInputStream fileInputStream2 = null;
        if (!d11.exists() || d11.length() == 0) {
            ob.g.f().b("No userId set for session " + str);
            m(d11);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(d11);
            try {
                try {
                    String g11 = g(CommonUtils.A(fileInputStream));
                    ob.g.f().b("Loaded userId " + g11 + " for session " + str);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return g11;
                } catch (Exception e11) {
                    e = e11;
                    ob.g.f().l("Error deserializing user metadata.", e);
                    m(d11);
                    CommonUtils.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void q(String str, Map map) {
        r(str, map, false);
    }

    public void r(String str, Map map, boolean z10) {
        String h11;
        BufferedWriter bufferedWriter;
        File a11 = z10 ? a(str) : b(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                h11 = h(map);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a11), f74372b));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e11) {
            e = e11;
        }
        try {
            bufferedWriter.write(h11);
            bufferedWriter.flush();
            CommonUtils.f(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e12) {
            e = e12;
            bufferedWriter2 = bufferedWriter;
            ob.g.f().l("Error serializing key/value metadata.", e);
            m(a11);
            CommonUtils.f(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.f(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public void s(String str, List list) {
        Throwable th2;
        BufferedWriter bufferedWriter;
        Exception e11;
        File c11 = c(str);
        ?? isEmpty = list.isEmpty();
        if (isEmpty != 0) {
            n(c11, "Rollout state is empty for session: " + str);
            return;
        }
        try {
            try {
                String l11 = l(list);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c11), f74372b));
                try {
                    bufferedWriter.write(l11);
                    bufferedWriter.flush();
                    isEmpty = bufferedWriter;
                } catch (Exception e12) {
                    e11 = e12;
                    ob.g.f().l("Error serializing rollouts state.", e11);
                    m(c11);
                    isEmpty = bufferedWriter;
                    CommonUtils.f(isEmpty, "Failed to close rollouts state file.");
                }
            } catch (Throwable th3) {
                th2 = th3;
                CommonUtils.f(isEmpty, "Failed to close rollouts state file.");
                throw th2;
            }
        } catch (Exception e13) {
            bufferedWriter = null;
            e11 = e13;
        } catch (Throwable th4) {
            isEmpty = 0;
            th2 = th4;
            CommonUtils.f(isEmpty, "Failed to close rollouts state file.");
            throw th2;
        }
        CommonUtils.f(isEmpty, "Failed to close rollouts state file.");
    }

    public void t(String str, String str2) {
        String o11;
        BufferedWriter bufferedWriter;
        File d11 = d(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                o11 = o(str2);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d11), f74372b));
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedWriter.write(o11);
            bufferedWriter.flush();
            CommonUtils.f(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e12) {
            e = e12;
            bufferedWriter2 = bufferedWriter;
            ob.g.f().l("Error serializing user metadata.", e);
            CommonUtils.f(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            CommonUtils.f(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
