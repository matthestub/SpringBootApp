//package com.course.todo.todocourse.noMoreUsedClasses;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.validation.Validator;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//
//@SpringBootApplication
//public class TodocourseApplicationOld implements RepositoryRestConfigurer {
//
//	public static void main(String[] args) {
//		SpringApplication.run(TodocourseApplicationOld.class, args);
//	}
//
//
//	/*
//	@Bean - oznacza, że obiekt zwrócony przez tą metodę będzie zarządzany przez springa. Jest to szczególnie przydatne gdy maven dociąga jaką bibliotekę której Spring nie zna i nie może zarządzać jej wewnętrzną zawartością.
//	Jeśli posługuję się taką nieznaną dla springa bibliotką to nie mam możliwość by w nią wejść bo będzie ona w postaci spakowanego jara. Wówczas mogę jak tutaj utworzć metodę która zwraca obiekt z tej biblioteki
//	i oznaczyć go adnotacją Bean co spowoduję że spring od tej pory będzie mógł nią zarzadzać. Adnotację Bean muszę umieścić w klasie z konfiguracją Springa.
//	 */
//	@Bean
//	Validator validate() {
//		return new LocalValidatorFactoryBean();
//	}
//
//	@Override
//	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
//		validatingListener.addValidator("beforeCreate", validate());
//		validatingListener.addValidator("beforeSave", validate());
//	}
//}
