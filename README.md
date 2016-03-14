# DelTaEMF

This project is the EMF implementation of DelTa metamodel and models. You will need Eclipse EMF in order to create the project and view EMF files. The rest of the philosophy can be found here: http://hergin.students.cs.ua.edu/#research

## Inside the project

There are:

- DelTa metamodel (src/metamodel/DelTa.ecore)
   - Design pattern instances in DelTa (src/designpattern/*.xmi)
- DelTa Configuration metamodel (src/metamodel/DelTaConfig.ecore)
  - Configuration instaces in DelTaConfig (src/config/*.xmi)
- [ATL] transformation from DelTa to Henshin (src/atl/delta2henshin.atl)
  - ATL launch configurations for different transformation cases (src/atl/launch/*.launch)
- [XPand] templates from DelTa to Henshin and GrGEN.NET along with helpers (template/*xpt and template/*.ext)
  - XPand workflows for Henshin and GrGEN.NET (workflow/*.mwe)

[ATL]: <https://eclipse.org/atl/>
[XPand]: <https://eclipse.org/modeling/m2t/?project=xpand>
