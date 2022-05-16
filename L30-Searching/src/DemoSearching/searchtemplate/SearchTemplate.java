package DemoSearching.searchtemplate;

public class SearchTemplate {
// SM - søgemængden
// M  - målelementet
// KM - kandidatmængden

//  <INITIALISER RESULTAT TIL IKKE_FUNDET>
//  <INITIALISER KM>
//  while ( <RESULTAT ER IKKE-FUNDET> && <KM != empty set> ) { 
//      <UDVÆLG K FRA KM>
//      if ( <K ER LIG M> ) {
//          <SÆT RESULTAT (M ER FUNDET)>
//      }
//      <SPLIT KM I FORHOLD TIL K OG M>
//  }

// ALTERNATIV formulering af søgeskabelon:

//  <INITIALISER KM>
//  while ( <KM != empty set> ) { 
//      <UDVÆLG K FRA KM>
//      if ( <K ER LIG M> ) {
//          return <ET RESULTAT (M ER FUNDET)>
//      }
//      <SPLIT KM I FORHOLD TIL K OG M>
//  }
//  return <ET RESULTAT (M ER IKKE FUNDET)>

}
