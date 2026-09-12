package ng;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class a implements h8.b {

    /* renamed from: a, reason: collision with root package name */
    private ThreadLocal f70574a = new C0878a();

    /* renamed from: ng.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0878a extends ThreadLocal {
        C0878a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        }
    }

    @Override // h8.b
    public String a(int i11, long j11) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) this.f70574a.get();
        if (simpleDateFormat != null) {
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
        }
        if (simpleDateFormat == null) {
            return UUID.randomUUID() + ".log";
        }
        return simpleDateFormat.format(new Date(j11)) + ".log";
    }

    @Override // h8.b
    public boolean b() {
        return true;
    }
}
