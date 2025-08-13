#!/bin/bash

set -e

SHORT=t,:
LONG=tag,:
TAG='v1.4.0'

while getopts t: flag
do
    case "${flag}" in
        t) TAG=${OPTARG};;
    esac
done

echo "Tag used: $TAG"

echo "Cloning the compound-design-tokens repository..."
if [ -d tmp ]; then
    echo "Deleting tmp folder..."
    rm -rf tmp
fi
mkdir tmp
pushd tmp
git clone --depth 1 --branch $TAG https://github.com/element-hq/compound-design-tokens

echo "Copying files from tokens repository..."
cp -R compound-design-tokens/assets/android/res/drawable ../compound/src/main/res/
cp -R compound-design-tokens/assets/android/src/* ../compound/src/main/kotlin/io/element/android/compound/tokens/generated/
popd

echo "Adding autoMirrored attribute..."
python3 ./scripts/addAutoMirrored.py

echo "Removing temporary files..."
rm -rf tmp

echo "Done!"
