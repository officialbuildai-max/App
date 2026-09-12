package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f9788a = versionedParcel.p(audioAttributesImplBase.f9788a, 1);
        audioAttributesImplBase.f9789b = versionedParcel.p(audioAttributesImplBase.f9789b, 2);
        audioAttributesImplBase.f9790c = versionedParcel.p(audioAttributesImplBase.f9790c, 3);
        audioAttributesImplBase.f9791d = versionedParcel.p(audioAttributesImplBase.f9791d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.f9788a, 1);
        versionedParcel.F(audioAttributesImplBase.f9789b, 2);
        versionedParcel.F(audioAttributesImplBase.f9790c, 3);
        versionedParcel.F(audioAttributesImplBase.f9791d, 4);
    }
}
