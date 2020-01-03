package com.sonan.mvc;

/**
 * mvc 의 Model
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2020-01-02
 * @since: 1.8
 */
public interface Model<T extends Model> {
  T clone();
}
