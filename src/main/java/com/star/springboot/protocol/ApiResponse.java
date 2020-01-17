package com.star.springboot.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName ApiResponse
 * @Description 相应对象
 * @Author Administrator
 * @Date 2020/1/17 15:22
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

	private static final long serialVersionUID = -3818996747837866200L;

	private Integer code;

	private String message;

	private T data;

	public ApiResponseBuilder builder() {
		return new ApiResponseBuilder();
	}

	public class ApiResponseBuilder {

		private Integer code;

		private String message;

		private T data;

		public ApiResponseBuilder code(Integer code) {
			this.code = code;
			return this;
		}

		public ApiResponseBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ApiResponseBuilder data(T data) {
			this.data = data;
			return this;
		}

		public ApiResponse<T> build() {
			return new ApiResponse<>(code, message, data);
		}
	}
}
