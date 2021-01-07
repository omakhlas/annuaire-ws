package fr.kata.contact.annuairews.repository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import fr.kata.contact.annuairews.domain.QContact;

public class ContactPredicate {
	
	public static Predicate findBySearchCriteria(
			String firstName,
			String lastName,
			String email,
			String company,
			String departement
			
			
			) {
		QContact qContact = QContact.contact;
		BooleanBuilder builderSearchCriteria = new BooleanBuilder();
		if(!"".equals(firstName) && null != firstName) builderSearchCriteria.and(qContact.first_name.contains(firstName));
		if(!"".equals(lastName) && null != lastName) 
			builderSearchCriteria.and(qContact.last_name.contains(lastName));
		if(!"".equals(email) && null != email) builderSearchCriteria.and(qContact.email.contains(email));
		if(!"".equals(company) && null != company) builderSearchCriteria.and(qContact.company.contains(company));
		if(!"".equals(departement) && null != departement) builderSearchCriteria.and(qContact.departement.contains(departement));
	
		BooleanExpression searchContact = qContact.in(JPAExpressions
				.select(qContact)
				.from(qContact)
	            .where(builderSearchCriteria)
	            );
		BooleanBuilder builderContact = new BooleanBuilder();
		builderContact.and(searchContact);
        return builderContact;
	}

}
