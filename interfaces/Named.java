package interfaces;

public interface Named {
	
void setGivenName(String givenName);	
String getGivenName();

void setFamilyName(String familyName);
String getFamilyName();

void setFullName(String fullName); //Skal ta inn fornavn og etternavn skilt med mellomrom som argument.
String getFullName(); //Skal returnere fornavn og etternavn skilt med mellomrom.

}
