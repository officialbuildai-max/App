package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f9786a;

    /* renamed from: b, reason: collision with root package name */
    public int f9787b;

    public AudioAttributesImplApi21() {
        this.f9787b = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioAttributesImplApi21(AudioAttributes audioAttributes, int i11) {
        this.f9786a = audioAttributes;
        this.f9787b = i11;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f9786a.equals(((AudioAttributesImplApi21) obj).f9786a);
        }
        return false;
    }

    public int hashCode() {
        return this.f9786a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f9786a;
    }
}
