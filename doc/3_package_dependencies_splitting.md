# Dependencies package

## Create recipe based on library from repo

```
devtool add libanswer https://github.com/LetoThe2nd/libanwser
```

## Edit example-image.bb file adding

```
IMAGE_INSTALL += "libanswer"
```

```
bitbake example-image
```

## Using layer

```
runqemu qemuarm example-image nographic
```

## Run time dependencies, error will arrive sh: bc: not found

## Edit recipe

```
devtool edit-recipe libanwser
```

## Adding run time dependencie, prepared per package

In recipe file should be defined

```
RDEPENDS_${PN} = "bc"
```

After added, rebuild

```
bitbake example-image
```

## Clean one specific recipe

```
bitbake -c cleansstate libanwser && bitbake libanwser
```

```
PACKAGES =+ "${PN}-example"
```

# Splitting

```
bitbake libanswer
```

```
FILES_${PN}-example = " \
	/usr/bin/ask \
"
```

```
bitbake example-image
```

# Edit example-image.bb to add example application

```
IMAGE_INSTALL += "libanswer libanswer-example"
```

Rebuild

```
bitbake example-image
```