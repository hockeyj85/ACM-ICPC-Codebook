# ACM-ICPC-Codebook

Useful code snippets and other goodies for competative programming

# Languages Used

**Java**

# Coding Conventions/Guidelines

* Tabs not spaces. (gives more code formating options)
* Open braces on the same lines as function definitions. (to save space)
* Implementations of algorithms should be contained within a working java class that will compile and do some sort of sanity check.
* To include only the important part of a source file in the notebook, surround the relevant part with the delimiter lines:

```java
/* START SOLUTION */
/* END SOLUTION */
```

# Notebook generation

Generate a notebook by running:

```sh
./generate_notebook.sh
```

After you have run:
```
./setup.sh
```

The notebook is generated using [notebook-gen](https://github.com/BudgieInWA/notebook-gen).

# Deploying to github pages.

Just work on the master branch and ignore the gh-pages branch entirely, after generating a new notebook run the following command to force update the remote gh-pages branch with the local master branch.

```sh
git push -f origin master:gh-pages
```

Will be deployed at [http://hockeyj85.github.io/ACM-ICPC-Codebook](http://hockeyj85.github.io/ACM-ICPC-Codebook).
