package i8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* loaded from: classes4.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private String f65154a;

    /* renamed from: b, reason: collision with root package name */
    private File f65155b;

    /* renamed from: c, reason: collision with root package name */
    private BufferedWriter f65156c;

    @Override // i8.b
    public void a(String str) {
        try {
            this.f65156c.write(str);
            this.f65156c.newLine();
            this.f65156c.flush();
        } catch (Exception e11) {
            b8.b.e().g("append log failed: " + e11.getMessage());
        }
    }

    @Override // i8.b
    public boolean b() {
        BufferedWriter bufferedWriter = this.f65156c;
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f65156c = null;
        this.f65154a = null;
        this.f65155b = null;
        return true;
    }

    @Override // i8.b
    public File c() {
        return this.f65155b;
    }

    @Override // i8.b
    public String d() {
        return this.f65154a;
    }

    @Override // i8.b
    public boolean e() {
        return this.f65156c != null && this.f65155b.exists();
    }

    @Override // i8.b
    public boolean f(File file) {
        boolean z10;
        this.f65154a = file.getName();
        this.f65155b = file;
        if (file.exists()) {
            z10 = false;
        } else {
            try {
                File parentFile = this.f65155b.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f65155b.createNewFile();
                z10 = true;
            } catch (Exception e11) {
                e11.printStackTrace();
                b();
                return false;
            }
        }
        try {
            this.f65156c = new BufferedWriter(new FileWriter(this.f65155b, true));
            if (z10) {
                g(this.f65155b);
            }
            return true;
        } catch (Exception e12) {
            e12.printStackTrace();
            b();
            return false;
        }
    }

    public void g(File file) {
    }
}
