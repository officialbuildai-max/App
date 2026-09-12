package com.google.firebase.installations.local;

import com.google.firebase.f;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PersistedInstallation {

    /* renamed from: a, reason: collision with root package name */
    private File f31962a;

    /* renamed from: b, reason: collision with root package name */
    private final f f31963b;

    /* loaded from: classes.dex */
    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(f fVar) {
        this.f31963b = fVar;
    }

    private File a() {
        if (this.f31962a == null) {
            synchronized (this) {
                try {
                    if (this.f31962a == null) {
                        this.f31962a = new File(this.f31963b.k().getFilesDir(), "PersistedInstallation." + this.f31963b.o() + ".json");
                    }
                } finally {
                }
            }
        }
        return this.f31962a;
    }

    private JSONObject c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(a());
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 16384);
                    if (read < 0) {
                        JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                        fileInputStream.close();
                        return jSONObject;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    public b b(b bVar) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bVar.d());
            jSONObject.put("Status", bVar.g().ordinal());
            jSONObject.put("AuthToken", bVar.b());
            jSONObject.put("RefreshToken", bVar.f());
            jSONObject.put("TokenCreationEpochInSecs", bVar.h());
            jSONObject.put("ExpiresInSecs", bVar.c());
            jSONObject.put("FisError", bVar.e());
            createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f31963b.k().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (createTempFile.renameTo(a())) {
            return bVar;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }

    public b d() {
        JSONObject c11 = c();
        String optString = c11.optString("Fid", null);
        int optInt = c11.optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String optString2 = c11.optString("AuthToken", null);
        String optString3 = c11.optString("RefreshToken", null);
        long optLong = c11.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = c11.optLong("ExpiresInSecs", 0L);
        return b.a().d(optString).g(RegistrationStatus.values()[optInt]).b(optString2).f(optString3).h(optLong).c(optLong2).e(c11.optString("FisError", null)).a();
    }
}
