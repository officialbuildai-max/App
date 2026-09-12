package com.transsion.athena.taaneh;

import java.io.File;
import java.util.Comparator;

/* loaded from: classes5.dex */
class ehanat implements Comparator<File> {
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return file.getName().compareTo(file2.getName());
    }
}
